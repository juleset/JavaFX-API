package org.example.model;

import java.util.UUID;

public class Artist {
        private final UUID id;
        private String name;


        public Artist(String name) {
            this.id = UUID.randomUUID();
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public UUID getId() {
            return id;
        }

}
