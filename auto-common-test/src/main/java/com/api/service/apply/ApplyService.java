package com.api.service.apply;

import com.api.entity.apply.*;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public interface ApplyService {
    public String applyInstall(ApplyInstall applyInstall) throws IOException;
    public String applyOpen(ApplyOpen applyOpen) throws IOException;
    public String applyUnInstall(ApplyUnInstall applyUnInstall) throws IOException;
    public String applyClose(ApplyClose applyClose) throws IOException;
    public String applyList(ApplyList applyList) throws IOException;
    public String applySearch(SearchApply searchApply) throws IOException;
    public String applyUpdate(ApplyUpdate applyUpdate) throws IOException;

}
