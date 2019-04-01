package com.example.user.epam_hw.backend;

import com.example.user.epam_hw.util.ICallback;

import java.util.List;

public interface IWebService<T> {

    void getEntities(final ICallback<List<T>> callback);

    void getEntities(final int startRange,
                     final int endRange,
                     final ICallback<List<T>> callback);

    void removeEntity(final Long id);

    void addEntity(final String name, final int homeworkCount);

    void editEntity(final long id, final String name, final int homeworkCount);
}