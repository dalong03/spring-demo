package com.fb.webdemo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fb.webdemo.common.service.CrudServiceImpl;
import com.fb.webdemo.dao.ItemDao;
import com.fb.webdemo.entity.Item;
import com.fb.webdemo.service.ItemService;

@Service
public class ItemServiceImpl extends CrudServiceImpl<ItemDao, Item> implements ItemService {

	@Autowired
	private ItemDao itemDao;

	public List<Item> findList(Item item) {
		item.setItemLevel(Item.ITEM_LEVEL_1);
		List<Item> items = itemDao.findList(item);
		for (Item i1 : items) {
			Item item2Query = new Item();
			item2Query.setItemLevel(Item.ITEM_LEVEL_2);
			item2Query.setParentId(i1.getId());
			List<Item> items2 = itemDao.findList(item2Query);
			i1.setItems(items2);
			for (Item i2 : items2) {
				Item item3Query = new Item();
				item3Query.setItemLevel(Item.ITEM_LEVEL_3);
				item3Query.setParentId(i2.getId());
				List<Item> items3 = itemDao.findList(item3Query);
				i2.setItems(items3);
			}
		}
		return items;
	}
}
