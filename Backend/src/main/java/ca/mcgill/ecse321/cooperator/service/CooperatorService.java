package ca.mcgill.ecse321.cooperator.service;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ca.mcgill.ecse321.cooperator.dao.CoopPlacementFormRepository;
import ca.mcgill.ecse321.cooperator.dao.CoopPositionRepository;
import ca.mcgill.ecse321.cooperator.dao.CooperatorAppRepository;
import ca.mcgill.ecse321.cooperator.dao.EmployerRepository;
import ca.mcgill.ecse321.cooperator.dao.EvaluationFormRepository;
import ca.mcgill.ecse321.cooperator.dao.EventRepository;
import ca.mcgill.ecse321.cooperator.dao.StartConfirmationRepository;
import ca.mcgill.ecse321.cooperator.dao.StudentRepository;
import ca.mcgill.ecse321.cooperator.dao.TaxCreditFormRepository;
import ca.mcgill.ecse321.cooperator.model.CoopPlacementForm;
import ca.mcgill.ecse321.cooperator.model.CoopPosition;
import ca.mcgill.ecse321.cooperator.model.Employer;
import ca.mcgill.ecse321.cooperator.model.EvaluationForm;
import ca.mcgill.ecse321.cooperator.model.Event;
import ca.mcgill.ecse321.cooperator.model.StartConfirmation;
import ca.mcgill.ecse321.cooperator.model.Student;
import ca.mcgill.ecse321.cooperator.model.TaxCreditForm;


@Service
public class CooperatorService {
	
	@Autowired
	CooperatorAppRepository repo;
	
	@Autowired
	private CoopPlacementFormRepository  coopPlacementFormRepository;
	
	@Autowired
	private CoopPositionRepository coopPositionRepository;
	
	@Autowired
	private EmployerRepository employerRepository;
	
	@Autowired
	private EvaluationFormRepository evaluationFormRepository;
	
	@Autowired
	private EventRepository eventRepository;
	
	@Autowired 
	private StartConfirmationRepository startConfirmationRepository;
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private TaxCreditFormRepository taxCreditFormRepository;
	
//	CoopPlacementForm
	
	@Transactional
	public CoopPlacementForm createCoopPlacementForm(int ID) {
		if (ID == 0) {
			throw new IllegalArgumentException("Coop Placement Form ID can't be 0");
		}
		CoopPlacementForm p = new CoopPlacementForm();
		p.setCoopPlacementFormID(ID);
		coopPlacementFormRepository.save(p);	
		return p;
	}

	@Transactional
	public CoopPlacementForm getCoopPlacementForm(int ID) {
		if (ID == 0) {
			throw new IllegalArgumentException("Coop Placement Form ID can't be 0");
		}
		 return coopPlacementFormRepository.findByCoopPlacementFormID(ID);	
	}
	
	@Transactional
	public List<CoopPlacementForm> getAllCoopPlacementForms() {
		return toList(coopPlacementFormRepository.findAll());
	}
	
	
	
	
// CoopPosition
	
	@Transactional
	public CoopPosition createCoopPosition(int ID,String PosName, String compName, Date startDate, Date endDate ) {
		CoopPosition p = new CoopPosition();
		p.setPositionID(ID);
		p.setPositionName(PosName);
		p.setCompanyName(compName);
		p.setStartDate(startDate);
		p.setEndDate(endDate);
		coopPositionRepository.save(p);
		return p;
	}

	@Transactional
	public CoopPosition getCoopPosition(int ID) {
		return coopPositionRepository.findByPositionID(ID);	
	}
	
	@Transactional
	public List<CoopPosition> getAllCoopPositions() {
		return toList(coopPositionRepository.findAll());
	}
	
	
	@Transactional
	public List<CoopPosition> getAllCoopPositionsWithThisCompanyName(String companyName) {
		return toList(repo.getCoopPositionWithCompanyName(companyName));
	}
	
	
	//Add CoopPosition in CoopPlacementForm and CoopPlacementForm in CoopPosition
	@Transactional 
	public void updateCoopPositionAndCoopPlacementForm(CoopPosition c, CoopPlacementForm cf) {
		c.setCoopPlacementForm(cf);
		cf.setCoopPosition(c);
		coopPositionRepository.save(c);
		coopPlacementFormRepository.save(cf);
	}
	
	//Add CoopPosition in StartConfirmation and StartConfirmation in CoopPosition
	@Transactional 
	public void updateCoopPositionAndStartConfirmation(CoopPosition c, StartConfirmation s) {
		c.setStartConfirmation(s);
		s.setCoopPosition(c);
		coopPositionRepository.save(c);
		startConfirmationRepository.save(s);
	}
	
	//Add CoopPosition in EvaluationForm and EvaluationForm in CoopPosition
	@Transactional 
	public void updateCoopPositionAndEvaluationForm(CoopPosition c, EvaluationForm s) {
		c.setEvaluationForm(s);;
		s.setCoopPosition(c);
		coopPositionRepository.save(c);
		evaluationFormRepository.save(s);
	}
	
	//Add CoopPosition in Student and Student in CoopPosition
	@Transactional 
	public void updateCoopPositionAndStudent(CoopPosition c, Student s) {
		List<CoopPosition> CoopPositionList = new ArrayList<>();
		CoopPositionList = s.getCoopPosition();
		CoopPositionList.add(CoopPositionList.size(), c);
		c.setStudent(s);
		s.setCoopPosition(CoopPositionList);
		coopPositionRepository.save(c);
		studentRepository.save(s);
	}
	
	//Add CoopPosition in TaxCreditForm and TaxCreditForm in CoopPosition
	@Transactional 
	public void updateCoopPositionAndTaxCreditForm(CoopPosition c, TaxCreditForm s) {
		c.setTaxCreditForm(s);
		s.setCoopPosition(c);
		coopPositionRepository.save(c);
		taxCreditFormRepository.save(s);
	}
	
	
	
//	Employer
	
	@Transactional
	public Employer createEmployer(String userName, String password,int ID ,String Company) {
		Employer p = new Employer();
		p.setUserName(userName);
		p.setPassword(password);
		p.setEmployeeID(ID);
		p.setCompany(Company);
		employerRepository.save(p);
		return p;
	}

	@Transactional
	public Employer getEmployer(int ID) {
		return employerRepository.findByEmployeeID(ID);
		
	}
	
	@Transactional
	public List<Employer> getAllEmployers() {
		return toList(employerRepository.findAll());
	}
	
	
	@Transactional
	public void updateEmployerAndStartConfirmation(Employer e, StartConfirmation s) {
		List<StartConfirmation> startConfirmationList = new ArrayList<>();
		startConfirmationList= e.getStartConfirmation();
		startConfirmationList.add(startConfirmationList.size(), s);
		e.setStartConfirmation(startConfirmationList);
		s.setEmployer(e);
		employerRepository.save(e);
		startConfirmationRepository.save(s);
	}
	
	@Transactional
	public void updateEmployerAndEvaluationForm(Employer e, EvaluationForm f) {
		List<EvaluationForm> EvaluationFormList = new ArrayList<>();
		EvaluationFormList= e.getEvaluationForm();
		EvaluationFormList.add(EvaluationFormList.size(), f );
		e.setEvaluationForm(EvaluationFormList);
		f.setEmployer(e);
		employerRepository.save(e);
		evaluationFormRepository.save(f);
	}
	
	
//	Events
	
	@Transactional
	public Event createEvents(String eventName ) {
		Event p = new Event();
		p.setName(eventName);
		eventRepository.save(p);
		return p;
	}

	@Transactional
	public Event getEvent(String eventName) {
		return eventRepository.findByName(eventName);
	}
	
	@Transactional
	public List<Event> getAllEvents() {
		return toList(eventRepository.findAll());
	}
	
//	EvaluationForm
	
	@Transactional
	public EvaluationForm createEvaluationForm(int ID) {
		EvaluationForm p = new EvaluationForm();
		p.setEvaluationFormID(ID);
		evaluationFormRepository.save(p);
		return p;
	}

	@Transactional
	public EvaluationForm getEvaluationForm(int ID) {
		return evaluationFormRepository.findByEvaluationFormID(ID);
		
	}
	
	@Transactional
	public List<EvaluationForm> getAllEvaluationForm() {
		return toList(evaluationFormRepository.findAll());
	}
	
//	TaxCreditForm
	
	@Transactional
	public TaxCreditForm createTaxCreditForm(int ID ) {
		TaxCreditForm p = new TaxCreditForm();
		p.setTaxCreditFormID(ID);
		taxCreditFormRepository.save(p);
		return p;
	}

	@Transactional
	public TaxCreditForm getTaxCreditForm(int ID ) {
		return taxCreditFormRepository.findByTaxCreditFormID(ID);	
	}
	
	@Transactional
	public List<TaxCreditForm> getAllTaxCreditForm() {
		return toList(taxCreditFormRepository.findAll());
	}
	
//	StartConfirmation
	
	@Transactional
	public StartConfirmation createStartConfirmation(Date date, int ID ) {
		StartConfirmation p = new StartConfirmation();
		p.setConfirmationID(ID);
		p.setEvaluationDate(date);
		startConfirmationRepository.save(p);
		return p;
	}

	@Transactional
	public StartConfirmation getStartConfirmation(int ID) {
		return startConfirmationRepository.findByConfirmationID(ID);
		
	}
	
	@Transactional
	public List<StartConfirmation> getAllStartConfirmations() {
		return toList(startConfirmationRepository.findAll());
	}
	
//	Student
	
	@Transactional
	public Student createStudent(int ID, String name ) {
		Student p = new Student();
		p.setStudentID(ID);
		p.setStudentName(name);
		studentRepository.save(p);
		return p;
	}

	@Transactional
	public Student getStudent(int ID) {
		return studentRepository.findByStudentID(ID);
	}
	
	@Transactional
	public List<Student> getAllStudents() {
		return toList(studentRepository.findAll());
	}
	
//	toList method
	
	private <T> List<T> toList(Iterable<T> iterable){
		List<T> resultList = new ArrayList<T>();
		for (T t : iterable) {
			resultList.add(t);
		}
		return resultList;
	}	

}
