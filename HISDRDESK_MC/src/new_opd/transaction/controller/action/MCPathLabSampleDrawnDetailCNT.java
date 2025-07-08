package new_opd.transaction.controller.action;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import hisglobal.exceptions.HisException;
import hisglobal.presentation.CSRFGardTokenAction;
import new_opd.transaction.controller.data.MCPathLabSampleDrawnDetailDATA;
import new_opd.transaction.controller.fb.MCPathLabSampleDrawnDetailFB;

public class MCPathLabSampleDrawnDetailCNT extends CSRFGardTokenAction {

	public ActionForward unspecified(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HisException, SQLException {
		generateToken(request);
		MCPathLabSampleDrawnDetailFB formBean = (MCPathLabSampleDrawnDetailFB) form;

		if (formBean.getStrWarningMsg().trim().length() > 0) {

			request.setAttribute("strWarningMsg", formBean.getStrWarningMsg());

		}

		return this.INITVAL(mapping, formBean, request, response);

	}

	public ActionForward INITVAL(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HisException, SQLException {
		generateToken(request);
		 MCPathLabSampleDrawnDetailFB formBean = (MCPathLabSampleDrawnDetailFB) form;

		MCPathLabSampleDrawnDetailDATA.getPatientsDtlNew(formBean, request);
		
		String target = "issue";
		return mapping.findForward(target);
	}

	public ActionForward getPrescribedTestDtl(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HisException, SQLException {
		generateToken(request);
		MCPathLabSampleDrawnDetailFB fb = (MCPathLabSampleDrawnDetailFB) form;

		fb.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		fb.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		
		MCPathLabSampleDrawnDetailDATA.getPrescribedTestDtl(fb, request,response);

		if (fb.getStrWarningMsg().trim().length() > 0) {

			request.setAttribute("strWarningMsg", fb.getStrWarningMsg());

			return this.INITVAL(mapping, fb, request, response);
		}
		else
			return null;

//		String target = "issueGo";
//		return mapping.findForward(target);
	}
	
	
	public ActionForward checkDuplicateVial(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HisException, SQLException {
		generateToken(request);
		MCPathLabSampleDrawnDetailFB fb = (MCPathLabSampleDrawnDetailFB) form;

		fb.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		fb.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		
		MCPathLabSampleDrawnDetailDATA.checkDuplicateVial(fb, request,response);

		if (fb.getStrWarningMsg().trim().length() > 0) {

			request.setAttribute("strWarningMsg", fb.getStrWarningMsg());

			return this.INITVAL(mapping, fb, request, response);
		}
		else
			return null;

//		String target = "issueGo";
//		return mapping.findForward(target);
	}
	



	
	public ActionForward save(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HisException, SQLException {

		MCPathLabSampleDrawnDetailFB fb = (MCPathLabSampleDrawnDetailFB) form;

		fb.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		fb.setStrSeatId(request.getSession().getAttribute("SEATID").toString());

		MCPathLabSampleDrawnDetailDATA.onSave(fb);

		if (fb.getStrWarningMsg().trim().length() > 0) {

			request.setAttribute("strWarningMsg", fb.getStrWarningMsg());

		} else if (fb.getStrErrMsg().trim().length() > 0) {

			request.setAttribute("strErrMsg", fb.getStrErrMsg());
		} else {

//			request.setAttribute("strNormalMsg", "Drugs Issued successfully with Issue No. " + fb.getStrIssueNo());
		}

		return this.INITVAL(mapping, fb, request, response);

	}

	public ActionForward BACK(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception, SQLException {

		return this.INITVAL(mapping, form, request, response);

	}

}
