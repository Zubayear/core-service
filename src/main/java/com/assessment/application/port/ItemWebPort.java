package com.assessment.application.port;

import com.assessment.application.usecase.Create;
import com.assessment.application.usecase.Delete;
import com.assessment.application.usecase.Read;
import com.assessment.application.usecase.Upsert;

public interface ItemWebPort extends Create, Read, Upsert, Delete {

}
