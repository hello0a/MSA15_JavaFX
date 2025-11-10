package application.DTO;

import java.util.Date;

import javafx.scene.control.CheckBox;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/*
 * 게시글 정보
 * 				Java			DB
 * 번호			no				no
 * 제목			title			title
 * 작성자 		writer			writer
 * 내용			content			content
 * 등록일자		createdAt		create_at
 * 수정일자		updatedAt		updated_at
 */

@Data
//@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class Board {
	
	private CheckBox check;
	private int no;
	// 필수 매개변수 생성자
	@NonNull private String title;
	@NonNull private String writer;
	@NonNull private String content;
	private Date createdAt;
	private Date updatedAt;
	
	public Board() {
		this.check = new CheckBox();
	}
}
