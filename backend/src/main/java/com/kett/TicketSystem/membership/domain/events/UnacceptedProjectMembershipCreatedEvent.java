package com.kett.TicketSystem.membership.domain.events;

import com.kett.TicketSystem.common.events.DomainEvent;
import lombok.Getter;

import java.util.UUID;

@Getter
public class UnacceptedProjectMembershipCreatedEvent extends DomainEvent {
    private final UUID inviteeId;
    private final UUID projectId;

    public UnacceptedProjectMembershipCreatedEvent(UUID inviteeId, UUID projectId) {
        super();
        this.inviteeId = inviteeId;
        this.projectId = projectId;
    }
}
