package com.devagit.springbootstudy.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "message")
public class Message {
    @GeneratedValue
    @Id
    private long id;
    @Column(columnDefinition = "VARCHAR(16)",nullable = false)
    private String sendUserId;
    @Column(columnDefinition = "VARCHAR(16)",nullable = false)
    private String receiveUserId;
    @Column(columnDefinition = "DATETIME",nullable = false)
    private LocalDateTime receiveTime;
    @Column(columnDefinition = "DATETIME",nullable = false)
    private LocalDateTime sendTime;
    @Column(columnDefinition = "DATETIME",nullable = false)
    private LocalDateTime readTime;
    private String title;
    private String content;
}
