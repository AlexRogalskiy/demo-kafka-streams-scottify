/*
 * Copyright 2020 StreamThoughts.
 *
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.streamthoughts.kafka.datagen.scottify;

import io.streamthoughts.kafka.datagen.scottify.command.GenerateAlbums;
import io.streamthoughts.kafka.datagen.scottify.command.GenerateMusics;
import io.streamthoughts.kafka.datagen.scottify.command.GenerateUser;
import io.streamthoughts.kafka.datagen.scottify.command.GenerateUserEvents;
import picocli.CommandLine;

import static picocli.CommandLine.Command;
import static picocli.CommandLine.Spec;
import static picocli.CommandLine.Model;
import static picocli.CommandLine.ParameterException;

@Command(name = "scottify",
         synopsisSubcommandLabel = "COMMAND",
         subcommands = { GenerateAlbums.class, GenerateMusics.class, GenerateUser.class, GenerateUserEvents.class})
class Scottify implements Runnable {

    @Spec
    Model.CommandSpec spec;
    public void run() {
        throw new ParameterException(spec.commandLine(), "Missing required subcommand");
    }
    public static void main(String... args) {
        System.exit(new CommandLine(new Scottify()).execute(args));
    }
}
