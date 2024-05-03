package com.example.demo.entities;

public class User {
    private Long id;
    private String name;
    
    public User(String name, Long id) {
        this.id = id;
        this.name = name;
    }

    public User(String name) {
        this(name,null);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }   

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
            User other = (User) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "User [id=" + id + "]";
    }

}
