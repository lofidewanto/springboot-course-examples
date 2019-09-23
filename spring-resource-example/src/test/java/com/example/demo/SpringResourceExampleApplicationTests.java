/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package com.example.demo;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringResourceExampleApplicationTests {

	@Autowired
	private ExampleUsingResource exampleUsingResource;

	@Test
	public void contextLoads() {
	}

	@Test
	public void loadHelloWorldFileManually() throws IOException {
		Resource loadHelloWorldFileManually = exampleUsingResource.loadHelloWorldFileManually();
		File file = loadHelloWorldFileManually.getFile();
		String fileContent = new String(Files.readAllBytes(file.toPath()));

		assertThat(fileContent, equalTo("demo-file.txt Hello World!"));
	}

	@Test
	public void loadHelloWorldFilePerInject() throws IOException {
		Resource loadHelloWorldFilePerInject = exampleUsingResource.loadHelloWorldFilePerInject();
		File file = loadHelloWorldFilePerInject.getFile();
		String fileContent = new String(Files.readAllBytes(file.toPath()));

		assertThat(fileContent, equalTo("demo-file.txt Hello World!"));
	}

	@Test
	public void loadHelloWorldFileLazily() throws IOException {
		Resource loadHelloWorldFileLazily = exampleUsingResource.loadHelloWorldFileLazily();
		File file = loadHelloWorldFileLazily.getFile();
		String fileContent = new String(Files.readAllBytes(file.toPath()));

		assertThat(fileContent, equalTo("demo-file.txt Hello World!"));
	}

	@Test
	public void loadHelloWorldFileWithAppContext() throws IOException {
		Resource loadHelloWorldFileWithAppContext = exampleUsingResource.loadHelloWorldFileWithAppContext();
		File file = loadHelloWorldFileWithAppContext.getFile();
		String fileContent = new String(Files.readAllBytes(file.toPath()));

		assertThat(fileContent, equalTo("demo-file.txt Hello World!"));
	}

}
