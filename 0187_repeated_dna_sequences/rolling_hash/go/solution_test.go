package repeateddnasequences

import (
	"slices"
	"testing"
)

func assertSameContents(t *testing.T, got []string, want []string) {
	t.Helper()

	gotCopy := append([]string(nil), got...)
	wantCopy := append([]string(nil), want...)
	slices.Sort(gotCopy)
	slices.Sort(wantCopy)

	if !slices.Equal(gotCopy, wantCopy) {
		t.Fatalf("got %v, want %v", got, want)
	}
}

func TestFindRepeatedDnaSequences(t *testing.T) {
	tests := []struct {
		name string
		s    string
		want []string
	}{
		{
			name: "example one",
			s:    "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",
			want: []string{"AAAAACCCCC", "CCCCCAAAAA"},
		},
		{
			name: "example two",
			s:    "AAAAAAAAAAAAA",
			want: []string{"AAAAAAAAAA"},
		},
		{
			name: "too short",
			s:    "ACGT",
			want: []string{},
		},
		{
			name: "exactly ten",
			s:    "ACGTACGTAC",
			want: []string{},
		},
		{
			name: "same fragment returned once",
			s:    "AAAAAAAAAAAA",
			want: []string{"AAAAAAAAAA"},
		},
	}

	for _, tc := range tests {
		t.Run(tc.name, func(t *testing.T) {
			assertSameContents(t, findRepeatedDnaSequences(tc.s), tc.want)
		})
	}
}
