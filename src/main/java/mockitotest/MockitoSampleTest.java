package mockitotest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import unittest.Calculator;

//拡張機能を追加
@ExtendWith(MockitoExtension.class)
class MockitoSampleTest {
	
	 // モック化するクラスをフィールドに追加
	 @Mock
	 private Calculator calc;
	 
	// テスト対象クラス（＝モックを利用するクラス）をフィールドに追加
	 @InjectMocks
	 private MockitoSample sample;


 @Test
//テスト結果表示用にテストメソッドの説明を記載
@DisplayName("getSquareResultに5を渡したときに25が表示できる")
 void test() {
	 // 1. テストの前準備として、モック化したクラスのセットアップを行う
	  when(calc.square(5)).thenReturn(25);
	  
	// 2. テスト対象メソッド（今回はgetSquareResultメソッド）を実行し、結果を取得する
	  String result = sample.getSquareResult(5);
	  
	  // 3. 実行結果の実測値と期待値の検証（アサーション）を行う
	  assertEquals(result, "5の二乗の結果は25");
	 }
}