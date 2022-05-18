package guru.springframework.sfgpetclinic.controllers;

import guru.springframework.sfgpetclinic.fauxspring.BindingResult;
import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.services.OwnerService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.ArgumentMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class OwnerControllerTest {

    private static final String OWNERS_CREATE_OR_UPDATE_OWNER_FORM = "owners/createOrUpdateOwnerForm";
    private static final String REDIRECT_OWNERS_5 = "redirect:/owners/5";

    @Mock
    OwnerService ownerService;

    @InjectMocks
    private OwnerController ownerController;

    @Mock
    BindingResult bindingResult;

    @Test
    void processFindFormWildcardsString() {
        //given
        Owner owner = new Owner(1L, "Bob", "Black");
        List<Owner> ownerList = new ArrayList<>();
        //final ArgumementCaptor

        //when

        //then
    }

    @Test
    void testProcessCreationFormHasErrors() {
        //given
        Owner owner = new Owner(1L, "Bob", "Tester");
        BDDMockito.given(bindingResult.hasErrors()).willReturn(true);

        //when
        String viewName = ownerController.processCreationForm(owner, bindingResult);

        //then
        Assertions.assertTrue(viewName.equalsIgnoreCase(OWNERS_CREATE_OR_UPDATE_OWNER_FORM));
    }

    /**
     * Make controller return view "redirect:/owners/5
     */
    @Test
    void testProcessCreationFormNoErrors() {
        //given
        Owner owner = new Owner(5L, "Bob", "Tester");
        BDDMockito.given(bindingResult.hasErrors()).willReturn(false);
        BDDMockito.given(ownerService.save(any())).willReturn(owner);

        //when
        String viewName = ownerController.processCreationForm(owner, bindingResult);

        //then
        Assertions.assertTrue(viewName.equalsIgnoreCase(REDIRECT_OWNERS_5));
    }
}