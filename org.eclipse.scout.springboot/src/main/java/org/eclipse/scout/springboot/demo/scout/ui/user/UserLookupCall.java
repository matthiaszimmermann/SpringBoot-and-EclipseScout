package org.eclipse.scout.springboot.demo.scout.ui.user;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.scout.rt.platform.BEANS;
import org.eclipse.scout.rt.shared.services.lookup.ILookupRow;
import org.eclipse.scout.rt.shared.services.lookup.LocalLookupCall;
import org.eclipse.scout.rt.shared.services.lookup.LookupRow;
import org.eclipse.scout.springboot.demo.model.User;
import org.eclipse.scout.springboot.demo.spring.service.UserService;

public class UserLookupCall extends LocalLookupCall<User> {

  private static final long serialVersionUID = 1L;

  @Override
  protected List<? extends ILookupRow<User>> execCreateLookupRows() {
    List<ILookupRow<User>> list = new ArrayList<>();

    for (User user : BEANS.get(UserService.class).getUsers()) {
      list.add(new LookupRow<>(user, user.toString()));
    }

    return list;
  }
}