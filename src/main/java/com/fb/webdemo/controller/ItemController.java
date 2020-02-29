package com.fb.webdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fb.webdemo.common.controller.BaseController;
import com.fb.webdemo.entity.Item;
import com.fb.webdemo.service.ItemService;

@Controller
@RequestMapping("/item")
public class ItemController extends BaseController {

	@Autowired
	private ItemService itemService;

	@RequestMapping("/t2")
	public String t2(Model model) {
		Item item = new Item();
		List<Item> list = itemService.findList(item);
		model.addAttribute("list", list);
		return "t2";
	}
}
