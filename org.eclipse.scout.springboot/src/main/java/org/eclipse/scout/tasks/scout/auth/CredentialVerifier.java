package org.eclipse.scout.tasks.scout.auth;

import java.io.IOException;

import javax.inject.Inject;

import org.eclipse.scout.rt.platform.security.ICredentialVerifier;
import org.eclipse.scout.rt.platform.util.StringUtility;
import org.eclipse.scout.tasks.model.User;
import org.eclipse.scout.tasks.spring.service.UserService;

public class CredentialVerifier implements ICredentialVerifier {

  @Inject
  private UserService userService;

  @Override
  public int verify(String username, char[] passwordPlainText) throws IOException {
    if (StringUtility.isNullOrEmpty(username) || passwordPlainText == null || passwordPlainText.length == 0) {
      return AUTH_CREDENTIALS_REQUIRED;
    }

    User user = userService.getUser(username);
    if (user == null || !user.getPassword().equals(String.valueOf(passwordPlainText))) {
      return AUTH_FORBIDDEN;
    }

    return AUTH_OK;
  }

}