import main
import pytest

@pytest.mark.parametrize('value1,value2,result',
                         [
                            ('czesc',' no', 'czesc no'),
                            (1,1,2),
                            ('czesc', '5', 'czesc5'),

                         ]
                         )
def test_add(value1,value2,result):
    assert main.add(value1,value2) == result