package iam.doky.user.application;

import iam.doky.user.payload.request.LoginRequest;

public interface AuthenticationService {

    public abstract String login(LoginRequest request);
}
