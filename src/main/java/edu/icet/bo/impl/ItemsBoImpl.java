package edu.icet.bo.impl;

import edu.icet.bo.ItemsBo;
import edu.icet.dao.ItemsDao;
import edu.icet.dao.ItemsDaoImpl;
import edu.icet.dto.ItemDto;
import edu.icet.entity.ItemsEntity;
public class ItemsBoImpl implements ItemsBo {

    private ItemsDao itemsDao;
    public ItemsBoImpl(){
        this.itemsDao = new ItemsDaoImpl();
    }

    @Override
    public boolean save(ItemDto dto) {
        boolean bool =itemsDao.save(new ItemsEntity(
                dto.getItemCode(),
                dto.getProductName(),
                dto.getCategory(),
                dto.getPrice()
        ));
        return bool;
    }
}
