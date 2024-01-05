package classy.classyapp.BackendApi.globalRequest;

public record ConfirmResetPasswordRequest(String email, String newPassword, String resetToken) {
} 