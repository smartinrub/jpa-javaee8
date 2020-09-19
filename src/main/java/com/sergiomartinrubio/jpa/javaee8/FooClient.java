package com.sergiomartinrubio.jpa.javaee8;

import com.sergiomartinrubio.jpa.javaee8.model.Foo;
import com.sergiomartinrubio.jpa.javaee8.model.FooChild;
import com.sergiomartinrubio.jpa.javaee8.repository.FooRepository;

import javax.ejb.EJB;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = "/foo")
public class FooClient extends HttpServlet {

    @EJB
    private FooRepository fooRepository;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try (PrintWriter out = response.getWriter()) {
            List<Foo> foos = fooRepository.findAll();
            for (Foo foo : foos) {
                out.println("Foo ID:" + foo.getId());
                out.println("Foo Name:" + foo.getName());
                if (foo.getFooChildren() != null) {
                    for (FooChild fooChild : foo.getFooChildren()) {
                        out.println("Foo Child ID:" + fooChild.getId());
                        out.println("Foo Child Name:" + fooChild.getName());
                    }
                }
                if (foo.getBar() != null) {
                    out.println("Bar ID:" + foo.getBar().getId());
                    out.println("Bar Name:" + foo.getBar().getName());
                }
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        Foo foo = new Foo();
        foo.setName("Foo Name");
        fooRepository.save(foo);
    }

    @Override
    public String getServletInfo() {
        return "Jpa servlet";
    }
}
