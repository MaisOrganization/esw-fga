package calculoDeIRPF.tests;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


import java.util.ArrayList;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.runners.MockitoJUnitRunner;


import calculoDeIRPF.Deducao;
import calculoDeIRPF.Dependente;
import calculoDeIRPF.IRPF;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(MockitoJUnitRunner.class)
public class DeducaoTest {
	
	IRPF irpf = new IRPF(); 

	
		@Test
		public void testCadastroPrimeiraDeducao() {
				
			Dependente dependente1 = mock(Dependente.class);
			this.irpf.addDependente(dependente1);
			Dependente dependente2 = mock(Dependente.class);
			this.irpf.addDependente(dependente2);
			
			System.out.println(this.irpf.getDependentes().size());
			
			when(dependente1.getDeducao()).thenReturn(100.0f);
			when(dependente2.getDeducao()).thenReturn(0.0f);
	
			Deducao d = new Deducao("Contribuicao previdenciaria", 
					                2000f);
			
			boolean resposta = irpf.cadastrarDedudacao(d);
			assertTrue(resposta); 
			assertEquals(2100f, irpf.totalDeducoes(), 0f);
			assertEquals(1, irpf.numTotalDeducoes());
		}

	@Test 
	public void testCadastroSegundaDeducao() {

		Dependente dependente1 = mock(Dependente.class);
		this.irpf.addDependente(dependente1);
		Dependente dependente2 = mock(Dependente.class);
		this.irpf.addDependente(dependente2);
		
		when(dependente1.getDeducao()).thenReturn(0.0f);
		when(dependente2.getDeducao()).thenReturn(0.0f);
		
		Deducao d = new Deducao("Plano de Saude", 
				                500f);
		
		boolean resposta = irpf.cadastrarDedudacao(d);
		assertTrue(resposta);
		assertEquals(500f, irpf.totalDeducoes(), 0f);
		assertEquals(1, irpf.numTotalDeducoes());
	}

}
