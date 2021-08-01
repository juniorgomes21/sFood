package com.sfood.controllers;


import com.sfood.dto.RequisicaoNovoRestaurante;
import com.sfood.models.Restaurantes;
import com.sfood.models.StatusRestaurantes;
import com.sfood.repositories.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class RestaurantesController {
    @Autowired
    private RestauranteRepository restauranteRepository;


    @GetMapping("/")
    public ModelAndView raiz() {
        return index();
    }

    @GetMapping("/restaurantes")
    public ModelAndView index() {
        List<Restaurantes> restaurantes = this.restauranteRepository.findAll();
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("restaurantes", restaurantes);

        return mv;
    }




    @GetMapping("/rest/novorestaurante")
    public ModelAndView novorest(RequisicaoNovoRestaurante requisicao){
        ModelAndView mv = new ModelAndView("restaurante/novo_restaurante");
        mv.addObject("listaStatusRestaurante", StatusRestaurantes.values());

        return mv;
    }

    @PostMapping("/rest/novorestaurante")
    public ModelAndView create(@Valid RequisicaoNovoRestaurante requisicao, BindingResult bindingResult){
        if(bindingResult.hasErrors()) {
            ModelAndView mv = new ModelAndView("restaurante/novo_restaurante");
            mv.addObject("listaStatusRestaurante", StatusRestaurantes.values());

            return mv;
        } else {
            Restaurantes restaurantes = requisicao.toRestaurante();
            this.restauranteRepository.save(restaurantes);

            return new ModelAndView("redirect:/restaurantes") ;
        }

    }

    @GetMapping("/rest/{id}/detalhes")
    public ModelAndView detalhe(@PathVariable Long id) {
        Optional<Restaurantes> optional = this.restauranteRepository.findById(id);
        if(optional.isPresent()) {
            Restaurantes restaurantes = optional.get();
            ModelAndView mv = new ModelAndView("restaurante/detalhe_restaurante");
            mv.addObject("restaurante", restaurantes);
            return mv;
        } else {

            return new ModelAndView("redirect:/");
        }
    }

    @GetMapping("rest/{id}/editar")
    public ModelAndView editar(@PathVariable Long id, RequisicaoNovoRestaurante resquisicao) {
        Optional<Restaurantes> optional = this.restauranteRepository.findById(id);
        if (optional.isPresent()){
            Restaurantes restaurantes = optional.get();
            resquisicao.fromRestaaurante(restaurantes);
            ModelAndView mv = new ModelAndView("restaurante/editar_restaurante");
            mv.addObject("restauranteId", restaurantes.getId());

            return mv;
        } else {

            return new ModelAndView("redirect:/");
        }

    }

    @PostMapping("/rest/{id}/editar")
    public ModelAndView editar(@PathVariable Long id, @Valid RequisicaoNovoRestaurante requisicao, BindingResult bindingResult){
        if(bindingResult.hasErrors()) {
            System.out.println("dentro do if -----------------------------------------");
            ModelAndView mv = new ModelAndView("restaurante/editar_restaurante");
            mv.addObject("restauranteId", id);
//            mv.addObject("listaStatusRestaurante", StatusRestaurantes.values());

            return mv;
        } else {
            Optional<Restaurantes> optional = this.restauranteRepository.findById(id);
            if(optional.isPresent()) {
                Restaurantes restaurantes = requisicao.toRestaurante(optional.get());
                this.restauranteRepository.save(restaurantes);

                return new ModelAndView("redirect:/rest/{id}/detalhes");
            } else {

                return new ModelAndView("redirect:/restaurantes") ;
            }
        }
    }

    @GetMapping("/rest/{id}/deletar")
    public String delete(@PathVariable Long id) {
        this.restauranteRepository.deleteById(id);

        return "redirect:/restaurantes";
    }
}
