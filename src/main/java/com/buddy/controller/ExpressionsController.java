package com.buddy.controller;

import com.buddy.dto.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
@RequestMapping("expressions")
public class ExpressionsController
{
    @GetMapping("Variable")
    public String getVariableExpression( Model model )
    {
        String firstName = "Lakshitha";
        String lastName = "Madushan";
        model.addAttribute( "firstName", firstName );
        model.addAttribute( "lastName", lastName );
        return "/expressions/variable";
    }

    @GetMapping("Selection")
    public String getSelectionExpression( Model model )
    {
        Student student = new Student( "Lakshitha", "Madushan", 25 );
        model.addAttribute( "student", student );

        Date date = new Date();
        model.addAttribute( "date", date );

        return "/expressions/selection";
    }

    @GetMapping("Message")
    public String getMessageExpression()
    {
        return "/expressions/message";
    }

    @GetMapping("Link")
    public String getLinkExpression()
    {
        return "/expressions/link";
    }

    @GetMapping("Fragment")
    public String getFragmentExpression()
    {
        return "/expressions/fragment";
    }
}
