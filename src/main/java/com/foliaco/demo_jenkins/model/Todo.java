package com.foliaco.demo_jenkins.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Todo {
    private Long id;
    private Long userId;
    private String title;
    private boolean completed;
}
