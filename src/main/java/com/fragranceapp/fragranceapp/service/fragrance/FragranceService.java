package com.fragranceapp.fragranceapp.service.fragrance;

import org.springframework.stereotype.Service;
import com.fragranceapp.fragranceapp.dto.FragranceDTO;

import java.util.List;
import java.util.Optional;

@Service
public interface  FragranceService {

    FragranceDTO createFragrance(FragranceDTO newFragrance);
    List<FragranceDTO> getAllFragrances();
    List<FragranceDTO> getAllFragrancesByCategoryId(long categoryId);
    FragranceDTO getFragranceById(long fragranceId);
    FragranceDTO updateFragrance(long fragranceId, FragranceDTO updateFragrance);
    void deleteFragrance(long fragranceId);
}
