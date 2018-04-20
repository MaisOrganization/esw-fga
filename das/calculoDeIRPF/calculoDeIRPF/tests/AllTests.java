package calculoDeIRPF.tests;

import org.junit.FixMethodOrder;
import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.junit.runners.Suite.SuiteClasses;

import calculoDeIRPF.AllanChorao;

@RunWith(Categories.class)
@IncludeCategory(AllanChorao.class)
@SuiteClasses({ DeducaoTest.class, RendimentoTest.class, RendimentosVaziosTest.class })
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AllTests {

}
