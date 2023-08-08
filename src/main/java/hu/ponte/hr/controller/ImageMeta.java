package hu.ponte.hr.controller;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

/**
 * @author zoltan
 */
@Getter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class ImageMeta
{
	@Id
	private String id;
	private String name;
	private String mimeType;
	private long size;
	@Column(length = 500)
	private String digitalSign;
	@Lob
	private byte[] imageData;
}
