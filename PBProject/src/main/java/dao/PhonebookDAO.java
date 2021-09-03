package dao;

import java.util.List;

import vo.PhonebookVO;

public interface PhonebookDAO {
	public List<PhonebookVO> getlist();

	public List<PhonebookVO> search(String keyword);

	public boolean insert(PhonebookVO vo);

	public boolean update(PhonebookVO vo);

	public boolean delete(Long id);

}