/*
 * Copyright 2011-2019 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"). You may not use this file except in compliance with
 * the License. A copy of the License is located at
 *
 * http://aws.amazon.com/apache2.0
 *
 * or in the "license" file accompanying this file. This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 * CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions
 * and limitations under the License.
 */
package com.amazonaws.services.rds;

import com.amazonaws.Request;
import com.amazonaws.services.rds.model.CreateDBClusterRequest;
import com.amazonaws.services.rds.model.transform.CreateDBClusterRequestMarshaller;

/**
 * Handler for pre-signing {@link CreateDBClusterRequest}.
 */
public class CreateDBClusterPresignHandler extends PresignRequestHandler<CreateDBClusterRequest> {

    public CreateDBClusterPresignHandler() {
        super(CreateDBClusterRequest.class);
    }

    @Override
    protected PresignableRequest adaptRequest(final CreateDBClusterRequest originalRequest) {
        return new PresignableRequest() {
            @Override
            public void setPreSignedUrl(String preSignedUrl) {
                originalRequest.setPreSignedUrl(preSignedUrl);
            }

            @Override
            public String getPreSignedUrl() {
                return originalRequest.getPreSignedUrl();
            }

            @Override
            public String getSourceRegion() {
                return originalRequest.getSourceRegion();
            }

            @Override
            public Request<?> marshall() {
                return new CreateDBClusterRequestMarshaller().marshall(originalRequest);
            }
        };
    }
}
