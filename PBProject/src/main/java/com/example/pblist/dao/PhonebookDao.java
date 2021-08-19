package com.example.pblist.dao;

import java.util.List;

import com.example.pblist.vo.PhonebookVo;

public interface PhonebookDao {
	public List<PhonebookVo> getList();
	public List<PhonebookVo> search(String keyword);
	public int insert(PhonebookVo vo);
	public int delete(Long pk);

}
