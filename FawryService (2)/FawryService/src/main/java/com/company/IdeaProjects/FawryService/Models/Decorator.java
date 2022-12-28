package com.company.IdeaProjects.FawryService.Models;

 abstract public class Decorator implements iPayment  {
     abstract public float pay(transaction transaction);
}
