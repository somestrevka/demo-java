package com.strevka.services;

import com.strevka.dto.AuthRequest;
import com.strevka.dto.TokenResponse;

public interface AuthService {
    public void register(AuthRequest request);
    public TokenResponse login(AuthRequest request);
}
