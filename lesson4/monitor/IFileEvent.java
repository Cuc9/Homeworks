package lesson4.monitor;

import java.nio.file.Path;

public interface IFileEvent {
	void onFileAdded(String s);
	void onFilesAdded();
	void onAnyTxtAdded(String fPath);
}
