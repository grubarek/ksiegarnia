package pl.ksiegarnia.rest.manager;

import pl.ksiegarnia.jpa.Book;

import java.util.List;

/**
 * Created by pgrubarek on 17.08.15.
 */
public interface iBook {


    pl.ksiegarnia.rest.model.Book create(pl.ksiegarnia.rest.model.Book book);

    pl.ksiegarnia.rest.model.Book edit(pl.ksiegarnia.rest.model.Book book);
}

