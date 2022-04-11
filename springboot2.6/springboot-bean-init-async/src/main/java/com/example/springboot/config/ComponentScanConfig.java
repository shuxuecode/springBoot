package com.example.springboot.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@ComponentScan(basePackages = {"com.example.springboot"}, lazyInit = true)
//@ComponentScan.Filter(type = FilterType.ANNOTATION)
public class ComponentScanConfig {
}
