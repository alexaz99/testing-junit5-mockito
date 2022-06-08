package guru.springframework.sfgpetclinic.controllers;

import guru.springframework.sfgpetclinic.fauxspring.BindingResult;
import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.services.OwnerService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

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

    @BeforeEach
    void setUp() {
        given(ownerService.findAllByLastNameLike(captor.capture())).willAnswer(invocation -> {

            List<Owner> ownerList = new ArrayList<>();
            String name = invocation.getArgument(0);
            return null;
        });
    }

    @Test
    void processFindFormWildcardsString() {
        //given
        Owner owner = new Owner(1L, "Bob", "Black");
        List<Owner> ownerList = new ArrayList<>();
        final ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);

        // do
        given(ownerService.findAllByLastNameLike(captor.capture())).willReturn(ownerList);

        //when
        String viewName = ownerController.processFindForm(owner, bindingResult, null);

        //then
        // Expecting %Black% and compare to captor value
        org.assertj.core.api.Assertions.assertThat("%Black%").isEqualToIgnoringCase(captor.getValue());
    }

    @Captor
    ArgumentCaptor<String> captor;


    @Test
    void processFindFormWildcardsStringAnnotation() {
        //given
        Owner owner = new Owner(1L, "Bob", "Black");
        List<Owner> ownerList = new ArrayList<>();

        // do agrument capture from this method
        given(ownerService.findAllByLastNameLike(captor.capture())).willReturn(ownerList);

        //when
        String viewName = ownerController.processFindForm(owner, bindingResult, null);

        //then
        // Expecting %Black% and compare to captor value
        org.assertj.core.api.Assertions.assertThat("%Black%").isEqualToIgnoringCase(captor.getValue());
    }

    @Test
    void testProcessCreationFormHasErrors() {
        //given
        Owner owner = new Owner(1L, "Bob", "Tester");
        given(bindingResult.hasErrors()).willReturn(true);

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
        given(bindingResult.hasErrors()).willReturn(false);
        given(ownerService.save(any())).willReturn(owner);

        //when
        String viewName = ownerController.processCreationForm(owner, bindingResult);

        //then
        Assertions.assertTrue(viewName.equalsIgnoreCase(REDIRECT_OWNERS_5));
    }
}