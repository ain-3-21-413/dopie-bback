package kg.kyljmeeski.dopie.mapper;

import kg.kyljmeeski.dopie.dto.response.AdminPredictionResponse;
import kg.kyljmeeski.dopie.entity.AdminPrediction;

public interface AdminPredictionMapper {

    AdminPredictionResponse toAdminPredictionResponse(AdminPrediction adminPrediction);
}
