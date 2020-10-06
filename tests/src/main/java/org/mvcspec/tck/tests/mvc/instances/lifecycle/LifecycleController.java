/*
 * Copyright © 2018 Christian Kaltepoth
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0, which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * This Source Code may also be made available under the following Secondary
 * Licenses when the conditions for such availability set forth in the
 * Eclipse Public License v. 2.0 are satisfied: GNU General Public License,
 * version 2 with the GNU Classpath Exception, which is available at
 * https://www.gnu.org/software/classpath/license.html.
 *
 * SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0
 */
package org.mvcspec.tck.tests.mvc.instances.lifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.inject.Inject;
import jakarta.mvc.Models;
import jakarta.mvc.Controller;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import java.util.concurrent.atomic.AtomicInteger;

@Controller
@Path("lifecycle/request")
public class LifecycleController {

    private static AtomicInteger sequence = new AtomicInteger(0);

    private int id;

    @Inject
    private Models models;

    @PostConstruct
    public void init() {
        this.id = sequence.incrementAndGet();
    }

    @GET
    public String queryParam() {
        models.put("id", id);
        return "view.jsp";
    }

}