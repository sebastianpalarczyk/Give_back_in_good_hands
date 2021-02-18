document.addEventListener("DOMContentLoaded", function() {

  /**
   * Form Select
   */
  class FormSelect {
    constructor($el) {
      this.$el = $el;
      this.options = [...$el.children];
      this.init();
    }

    init() {
      this.createElements();
      this.addEvents();
      this.$el.parentElement.removeChild(this.$el);
    }

    createElements() {
      // Input for value
      this.valueInput = document.createElement("input");
      this.valueInput.type = "text";
      this.valueInput.name = this.$el.name;

      // Dropdown container
      this.dropdown = document.createElement("div");
      this.dropdown.classList.add("dropdown");

      // List container
      this.ul = document.createElement("ul");

      // All list options
      this.options.forEach((el, i) => {
        const li = document.createElement("li");
        li.dataset.value = el.value;
        li.innerText = el.innerText;

        if (i === 0) {
          // First clickable option
          this.current = document.createElement("div");
          this.current.innerText = el.innerText;
          this.dropdown.appendChild(this.current);
          this.valueInput.value = el.value;
          li.classList.add("selected");
        }

        this.ul.appendChild(li);
      });

      this.dropdown.appendChild(this.ul);
      this.dropdown.appendChild(this.valueInput);
      this.$el.parentElement.appendChild(this.dropdown);
    }

    addEvents() {
      this.dropdown.addEventListener("click", e => {
        const target = e.target;
        this.dropdown.classList.toggle("selecting");

        // Save new value only when clicked on li
        if (target.tagName === "LI") {
          this.valueInput.value = target.dataset.value;
          this.current.innerText = target.innerText;
        }
      });
    }
  }
  document.querySelectorAll(".form-group--dropdown select").forEach(el => {
    new FormSelect(el);
  });

  /**
   * Hide elements when clicked on document
   */
  document.addEventListener("click", function(e) {
    const target = e.target;
    const tagName = target.tagName;

    if (target.classList.contains("dropdown")) return false;

    if (tagName === "LI" && target.parentElement.parentElement.classList.contains("dropdown")) {
      return false;
    }

    if (tagName === "DIV" && target.parentElement.classList.contains("dropdown")) {
      return false;
    }

    document.querySelectorAll(".form-group--dropdown .dropdown").forEach(el => {
      el.classList.remove("selecting");
    });
  });

  /**
   * Switching between form steps
   */
  class FormSteps {
    constructor(form) {
      this.$form = form;
      this.$next = form.querySelectorAll(".next-step");
      this.$prev = form.querySelectorAll(".prev-step");
      this.$step = form.querySelector(".form--steps-counter span");
      this.currentStep = 1;

      this.$stepInstructions = form.querySelectorAll(".form--steps-instructions p");
      const $stepForms = form.querySelectorAll("form > div");
      this.slides = [...this.$stepInstructions, ...$stepForms];

      this.init();
    }

    /**
     * Init all methods
     */
    init() {
      this.events();
      this.updateForm();
    }

    /**
     * All events that are happening in form
     */
    events() {
      // Next step
      this.$next.forEach(btn => {
        btn.addEventListener("click", e => {
          e.preventDefault();
          this.currentStep++;
          this.updateForm();
          const divStep3 = document.querySelectorAll("div .data-step");
          console.log(divStep3)
          const div = document.getElementById("11");
          const divClass = div.className;
          if(divClass === "active"){
            const quantity = document.querySelector("input#quantity");
            const institutions = document.getElementsByName("institutions");
            console.log(institutions);
            const institutionsList = [];
            institutions.forEach(function(element){
              if(element.checked === true){
                institutionsList.push(element.nextElementSibling.innerHTML);
              }
            });
            institutionsList.forEach(e=>console.log(e));
            console.log(institutionsList);
            const street = document.querySelector("input#street");
            const city = document.querySelector("input#city");
            const zipCode = document.querySelector("input#zipCode");
            const phone = document.querySelector("input#phone");
            const pickUpDate = document.querySelector("input#pickUpDate");
            const pickUpTime = document.querySelector("input#pickUpTime");
            const pickUpComment = document.querySelector("textarea");
            const spanQuantity = document.getElementById("12");
            const liStreet = document.getElementById("13");
            const liCity = document.getElementById("14");
            const liZipCode = document.getElementById("15");
            const liPhone = document.getElementById("16");
            const liDate = document.getElementById("17");
            const liTime = document.getElementById("18");
            const liComment = document.getElementById("19");
            const ul = document.getElementById("20");
            console.log(ul);
            const li = document.createElement("li");
            const span = document.createElement("span");
            span.className = "icon icon-hand";
            li.appendChild(span);
            ul.appendChild(li);
            for(let i=0; i<institutionsList.length; i++){
              const span2 = document.createElement("span");
              span2.className = "summary--text";
              span2.innerText = "Dla fundacji: "+institutionsList[i];
              li.appendChild(span2);
            }

            spanQuantity.innerText = quantity.value+" worki ubrań w dobrym stanie dla dzieci";
            liStreet.innerText = street.value;
            liCity.innerText = city.value;
            liZipCode.innerText = zipCode.value;
            liPhone.innerText = phone.value;
            liDate.innerText = pickUpDate.value;
            liTime.innerText = pickUpTime.value;
            liComment.innerText = pickUpComment.value;

          }
        });
      });

      // Previous step
      this.$prev.forEach(btn => {
        btn.addEventListener("click", e => {
          e.preventDefault();
          this.currentStep--;
          this.updateForm();
        });
      });

      // Form submit
      this.$form.querySelector("form").addEventListener("submit", e => this.submit(e));
    }

    /**
     * Update form front-end
     * Show next or previous section etc.
     */
    updateForm() {
      this.$step.innerText = this.currentStep;

      // TODO: Validation

      this.slides.forEach(slide => {
        slide.classList.remove("active");

        if (slide.dataset.step == this.currentStep) {
          slide.classList.add("active");
        }
      });

      this.$stepInstructions[0].parentElement.parentElement.hidden = this.currentStep >= 5;
      this.$step.parentElement.hidden = this.currentStep >= 5;

      // TODO: get data from inputs and show them in summary
    }

  }
  const form = document.querySelector(".form--steps");
  if (form !== null) {
    new FormSteps(form);
  }
});





