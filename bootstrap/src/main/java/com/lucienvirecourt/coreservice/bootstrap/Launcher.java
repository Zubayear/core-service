package com.lucienvirecourt.coreservice.bootstrap;

import com.lucienvirecourt.coreservice.SpringAppConfig;
import org.springframework.boot.SpringApplication;

/**
 * Launcher for the application: starts the Spring application.
 *
 * @author Syed Ibna Zubaeyar
 */
public class Launcher {

  public static void main(String[] args) {
    SpringApplication.run(SpringAppConfig.class, args);
  }
}
