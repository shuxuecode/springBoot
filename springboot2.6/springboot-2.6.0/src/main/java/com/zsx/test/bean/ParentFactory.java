package com.zsx.test.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParentFactory {


    @Autowired
    private List<Parent> parents;


    public List<Parent> getParents() {
        return parents;
    }

}
