package controller;

import controller.Action.Action;
import controller.Action.BoardCheckPassAction;
import controller.Action.BoardCheckPassFormAction;
import controller.Action.BoardDeleteAction;
import controller.Action.BoardListAction;
import controller.Action.BoardUpdateAction;
import controller.Action.BoardUpdateFormAction;
import controller.Action.BoardViewAction;
import controller.Action.BoardWriteAction;
import controller.Action.BoardWriteFormAction;
import controller.Action.MainAction;

import controller.Action.MemberJoinAction;
import controller.Action.MemberJoinFormAction;
import controller.Action.MemberLoginAction;
import controller.Action.MemberLoginFormAction;
import controller.Action.MemberLogoutAction;
import controller.Action.MemberModifyAction;
import controller.Action.MemberModifyFormAction;

public class ActionFactory {
	// 요청에 따라서 실제 동작할 객체를 만들어주는 역할
	public static Action getAction(String command) {

		Action action = null;
		if (command.equals("main")) {
			action = new MainAction();
		} else if (command.equals("member_login")) {
			action = new MemberLoginAction();
		} else if (command.equals("member_login_form")) {
			action = new MemberLoginFormAction();
		} else if (command.equals("member_join")) {
			action = new MemberJoinAction();
		} else if (command.equals("member_join_form")) {
			action = new MemberJoinFormAction();
		} else if (command.equals("member_modify")) {
			action = new MemberModifyAction();
		}else if (command.equals("member_modify_form")) {
			action = new MemberModifyFormAction();
		}else if(command.equals("board_list")) {
			action= new BoardListAction();
		}else if(command.equals("board_write_form")) {
			action= new BoardWriteFormAction();
		}else if(command.equals("board_write")) {
			action= new BoardWriteAction();
		}else if(command.equals("board_check_pass_form")) {
			action= new BoardCheckPassFormAction();
		}else if(command.equals("board_check_pass")) {
			action= new BoardCheckPassAction();
		}else if(command.equals("board_update_form")) {
			action= new BoardUpdateFormAction();
		}else if(command.equals("board_update")) {
			action= new BoardUpdateAction();
		}else if(command.equals("board_delete")) {
			action= new BoardDeleteAction();
		}else if(command.equals("board_view")) {
			action= new BoardViewAction();
		}else if (command.equals("logout")) {
			action = new MemberLogoutAction();
		}

		return action;
	}
}
