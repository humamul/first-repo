package com.prospecta.payloads;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SaveResponse {
	private EntryRequest entryRequest;
	private boolean saved;
}
