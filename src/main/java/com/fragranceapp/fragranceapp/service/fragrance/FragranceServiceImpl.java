package com.fragranceapp.fragranceapp.service.fragrance;

import com.fragranceapp.fragranceapp.dto.FragranceDTO;
import com.fragranceapp.fragranceapp.entity.persistence.FragranceCategoryEntity;
import com.fragranceapp.fragranceapp.entity.persistence.FragranceEntity;
import com.fragranceapp.fragranceapp.exceptions.categoryExceptions.FragranceCategoryNotFoundException;
import com.fragranceapp.fragranceapp.exceptions.fragranceExceptions.FragranceNotFoundException;
import com.fragranceapp.fragranceapp.mapper.Mapper;
import com.fragranceapp.fragranceapp.repository.FragranceCategoryRepository;
import com.fragranceapp.fragranceapp.repository.FragranceRepository;
import com.fragranceapp.fragranceapp.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FragranceServiceImpl implements FragranceService {

    private FragranceRepository fragranceRepository;
    private FragranceCategoryRepository fragranceCategoryRepository;
    private OrderRepository orderRepository;

    @Autowired
    public FragranceServiceImpl(FragranceRepository fragranceRepository,
                                FragranceCategoryRepository fragranceCategoryRepository) {
        this.fragranceRepository = fragranceRepository;
        this.fragranceCategoryRepository = fragranceCategoryRepository;
    }

    @Override
    public List<FragranceDTO> getAllFragrances() {
        List<FragranceEntity> fragrances = fragranceRepository.findAll();
        List<FragranceDTO> fragranceDTOS = fragrances.stream()
                .map(entity -> Mapper.fragranceToDto(entity))
                .collect(Collectors.toList());

        return fragranceDTOS;
    }

    @Override
    public FragranceDTO createFragrance (FragranceDTO newFragrance) {
        FragranceEntity fragrance = Mapper.dtoToFragrance(newFragrance);
        Optional<FragranceCategoryEntity> category = fragranceCategoryRepository.findCategoryById(newFragrance.getCategoryId());
        if(category.isEmpty()) {
            throw new FragranceCategoryNotFoundException("The category with id " + newFragrance.getCategoryId() + " couldn't be found");
        }
        fragrance.setFragranceCategoryEntity(category.get());
        fragranceRepository.save(fragrance);

        return newFragrance;
    }

    @Override
    public List<FragranceDTO> getAllFragrancesByCategoryId(long categoryId) {
         List<FragranceEntity> fragrances = fragranceRepository.getAllFragrancesByCategoryId(categoryId);
         List<FragranceDTO> fragranceDTOS = fragrances.stream()
                 .map(entity -> Mapper.fragranceToDto(entity))
                 .collect(Collectors.toList());

         return fragranceDTOS;
    }

    @Override
    public FragranceDTO getFragranceById(long fragranceId) {
        Optional<FragranceEntity> fragrance = fragranceRepository.findFragranceById(fragranceId);
        if(fragrance.isEmpty()) {
            throw new FragranceNotFoundException("The fragrance with id " + fragranceId + " doesn't exist");
        }

        return Mapper.fragranceToDto(fragrance.get());
    }

    @Override
    public FragranceDTO updateFragrance(long fragranceId, FragranceDTO updateFragrance) {
        Optional<FragranceEntity> fragrance = fragranceRepository.findFragranceById(fragranceId);
        if(fragrance.isEmpty()) {
            throw new FragranceNotFoundException("The fragrance with id " + fragranceId + " doesn't exist");
        }
        fragrance.get().setPrice(updateFragrance.getPrice());
        fragranceRepository.save(fragrance.get());

        return Mapper.fragranceToDto(fragrance.get());
    }

    @Override
    public void deleteFragrance(long fragranceId) {
        Optional<FragranceEntity> fragrance = fragranceRepository.findFragranceById(fragranceId);
        if(fragrance.isEmpty()) {
            throw new FragranceNotFoundException("The fragrance with id " + fragranceId + " doesn't exist");
        }

        fragranceRepository.deleteById(fragranceId);
    }
}
