package com.ProjectDetails.demo.Artifacts.ProjectDetails;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component
@ConditionalOnProperty(name="code.deploy", havingValue="prodDB")
public class ProdDB implements DB {
    public String getData() {
        return "getting prodDB";
    }
}
