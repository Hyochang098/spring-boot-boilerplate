package com.example.boilerplate.domain.user.controller;

import com.example.boilerplate.domain.user.dto.UserMeResponse;
import com.example.boilerplate.domain.user.repository.UserRepository;
import com.example.boilerplate.global.annotation.ApiErrorCodeExamples;
import com.example.boilerplate.global.exception.ApiException;
import com.example.boilerplate.global.response.ApiResult;
import com.example.boilerplate.global.response.ErrorCode;
import com.example.boilerplate.global.security.UserPrincipal;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "User", description = "사용자 API")
@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

  private final UserRepository userRepository;

  @Operation(summary = "내 정보 조회", description = "access token의 주인 정보를 반환한다.")
  @ApiErrorCodeExamples({ErrorCode.AUTH_TOKEN_INVALID, ErrorCode.USER_NOT_FOUND})
  @GetMapping("/me")
  public ResponseEntity<ApiResult<UserMeResponse>> getMe(
      @AuthenticationPrincipal UserPrincipal principal) {
    return ApiResult.success(
        userRepository
            .findById(principal.id())
            .map(UserMeResponse::from)
            .orElseThrow(() -> ApiException.of(ErrorCode.USER_NOT_FOUND)));
  }
}
