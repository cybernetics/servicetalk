/*
 * Copyright © 2018 Apple Inc. and the ServiceTalk project authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.servicetalk.http.router.jersey;

import io.servicetalk.concurrent.api.Publisher;
import io.servicetalk.http.api.HttpPayloadChunk;
import io.servicetalk.http.api.HttpRequest;
import io.servicetalk.transport.api.ConnectionContext;

import org.glassfish.jersey.internal.inject.ReferencingFactory;
import org.glassfish.jersey.internal.util.collection.Ref;

import java.lang.reflect.Type;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.ws.rs.core.GenericType;

final class Context {

    static final GenericType<Ref<ConnectionContext>> CONNECTION_CONTEXT_REF_GENERIC_TYPE =
            new GenericType<Ref<ConnectionContext>>() {
            };

    static final Type CONNECTION_CONTEXT_REF_TYPE = CONNECTION_CONTEXT_REF_GENERIC_TYPE.getType();

    static final GenericType<Ref<HttpRequest<HttpPayloadChunk>>> HTTP_REQUEST_REF_GENERIC_TYPE =
            new GenericType<Ref<HttpRequest<HttpPayloadChunk>>>() {
            };

    static final Type HTTP_REQUEST_REF_TYPE = HTTP_REQUEST_REF_GENERIC_TYPE.getType();

    static final GenericType<HttpRequest<HttpPayloadChunk>> HTTP_REQUEST_GENERIC_TYPE =
            new GenericType<HttpRequest<HttpPayloadChunk>>() {
            };

    static final GenericType<Ref<Ref<Publisher<HttpPayloadChunk>>>> CHUNK_PUBLISHER_REF_REF_GENERIC_TYPE =
            new GenericType<Ref<Ref<Publisher<HttpPayloadChunk>>>>() {
            };

    static final Type CHUNK_PUBLISHER_REF_TYPE = CHUNK_PUBLISHER_REF_REF_GENERIC_TYPE.getType();

    static final GenericType<Ref<Publisher<HttpPayloadChunk>>> CHUNK_PUBLISHER_REF_GENERIC_TYPE =
            new GenericType<Ref<Publisher<HttpPayloadChunk>>>() {
            };

    static final class ConnectionContextReferencingFactory extends ReferencingFactory<ConnectionContext> {
        @Inject
        ConnectionContextReferencingFactory(final Provider<Ref<ConnectionContext>> referenceFactory) {
            super(referenceFactory);
        }
    }

    static final class HttpRequestReferencingFactory extends ReferencingFactory<HttpRequest<HttpPayloadChunk>> {
        @Inject
        HttpRequestReferencingFactory(final Provider<Ref<HttpRequest<HttpPayloadChunk>>> referenceFactory) {
            super(referenceFactory);
        }
    }

    static final class ChunkPublisherRefReferencingFactory
            extends ReferencingFactory<Ref<Publisher<HttpPayloadChunk>>> {
        @Inject
        ChunkPublisherRefReferencingFactory(
                final Provider<Ref<Ref<Publisher<HttpPayloadChunk>>>> referenceFactory) {
            super(referenceFactory);
        }
    }

    private Context() {
        // no instances
    }
}
