package kg.kyljmeeski.dopie.controller;

import kg.kyljmeeski.dopie.dto.response.AdminPredictionResponse;
import kg.kyljmeeski.dopie.dto.response.MatchResponse;
import kg.kyljmeeski.dopie.entity.AdminPrediction;
import kg.kyljmeeski.dopie.mapper.AdminPredictionMapper;
import kg.kyljmeeski.dopie.mapper.MatchMapper;
import kg.kyljmeeski.dopie.service.AdminPredictionService;
import kg.kyljmeeski.dopie.service.MatchService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/matches")
public class MatchController {

    final MatchService matchService;
    final MatchMapper matchMapper;
    final AdminPredictionService adminPredictionService;
    final AdminPredictionMapper adminPredictionMapper;

    @GetMapping
    public List<MatchResponse> getMatches() {
        return matchService.getMatches().stream().map(matchMapper::toMatchResponse).toList();
    }

    @GetMapping("/top-matches")
    public List<MatchResponse> getTopMatches() {
        return matchService.getTopMatches().stream().map(matchMapper::toMatchResponse).toList();
    }

    @GetMapping("/top-match")
    public MatchResponse getTopMatch() {
        return getTopMatches().get(0);
    }

    @GetMapping("/{id}")
    public AdminPredictionResponse getMatch(@RequestParam String id) {
        return adminPredictionMapper.toAdminPredictionResponse(adminPredictionService.getAdminPredictionByMatchId(id));
    }
}
