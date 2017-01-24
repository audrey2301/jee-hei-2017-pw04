package hei.tp04.web.controller;

import hei.tp04.core.entity.Client;
import hei.tp04.core.service.ClientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.StringJoiner;

/**
 * Created by audrey on 24/01/2017.
 */
@Controller
public class ClientController {

   @Inject
   private ClientService clientService;

   protected String URL = "/WEB-INF/velocity/";

   @RequestMapping("/list")
   public String getListOfClients(ModelMap modelMap){
      List<Client> clientsList = clientService.findAllWithCommandes();
      modelMap.addAttribute("clients", clientsList);
      return "clientsList";
   }

   @RequestMapping("/form")
   public String getForm(ModelMap modelMap){
      modelMap.addAttribute("client", new Client());
      return "clientsForm";
   }

   @RequestMapping(value = "/form", method = RequestMethod.POST)
   public String submitForm(@ModelAttribute("client") Client client){
      clientService.saveClient(client);
      return "redirect:list";
   }
}
