package com.lucienvirecourt.coreservice.adapter.in.rest.common;

/**
 * An error entity with a status and message returned via REST API in case of an error.
 *
 * @author Syed Ibna Zubaeyar
 */
public record ErrorEntity(int httpStatus, String errorMessage) {}
